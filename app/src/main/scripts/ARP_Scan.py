# -*- coding: utf-8 -*-
"""
@author: friea
"""

import threading
from scapy.all import ARP, Ether, get_if_list, conf, srp

def find_local_interface():
    # Ağ arayüzlerini bulan fonksiyon
    interfaces = get_if_list()
    return [interface for interface in interfaces if not interface.startswith("lo")]

def get_local_ip(interface):
    # Belirli bir ağ arayüzünün IP adresini bulan fonksiyon
    try:
        conf.iface = interface
        ip = conf.route.route()[0]
        return ip
    except Exception as e:
        print(f"Hata: {e}")
        return None

def arp_scan(interface, target_ip, result_list):
    # ARP taraması yapacak fonksiyon
    conf.iface = interface  # Kullanılacak ağ arayüzünü ayarla
    arp_request = ARP(pdst=target_ip)
    ether = Ether(dst="ff:ff:ff:ff:ff:ff")

    packet = ether/arp_request
    answered, _ = srp(packet, timeout=2, verbose=False)

    for snd, rcv in answered:
        result_list.append((rcv.psrc, rcv.hwsrc))

def scan_local_network(interface, target_ip):
    # Ağdaki cihazları tarayan fonksiyon
    result_list = []
    local_ip = get_local_ip(interface)

    if local_ip:
        target_ip = local_ip.split('.')[:-1]
        target_ip.append('0/24')  # Alt ağdaki tüm cihazları tarar

        for target in target_ip:
            thread = threading.Thread(target=arp_scan, args=(interface, target, result_list))
            thread.start()

        # Tüm thread'leri bekleyerek tamamlamalarını sağla
        for thread in threading.enumerate():
            if thread != threading.current_thread():
                thread.join()

    return result_list

def ARP_total():
    local_interfaces = find_local_interface()

    if local_interfaces:
        for interface in local_interfaces:
            print(f"Ağ arayüzü: {interface}")
            scan_results = scan_local_network(interface, None)

            # Sonuçları yazdır
        for result in scan_results:
            print(f"IP: {result[0]}\tMAC Address: {result[1]}")
        return scan_results
    else:
        print("Bağlı bir ağ arayüzü bulunamadı.")
