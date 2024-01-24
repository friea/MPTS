# -*- coding: utf-8 -*-
"""
@author: metis
"""
import threading
import socket

def tcp_scan(target_ip, target_port, result_list,open_list):
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.settimeout(1)

    try:
        sock.connect((target_ip, target_port))
        result_list.append((target_ip, target_port, "open"))
        open_list.append(target_port)
    except socket.error:
        result_list.append((target_ip, target_port, "closed"))
    finally:
        sock.close()

def TCP_total(target_ip, start_port, end_port):
    result_list = []
    threads = []
    open_list=[]

    for port in range(start_port, end_port + 1):
        thread = threading.Thread(target=tcp_scan, args=(target_ip, port, result_list,open_list))
        threads.append(thread)
        thread.start()

    # Tüm thread'leri bekleyerek tamamlamalarını sağla
    for thread in threads:
        thread.join()

    return open_list

# Kullanım örneği:
target_ip = "192.168.1.33"  # Hedef IP adresi
start_port = 1
end_port = 1024

scan_results = TCP_total(target_ip, start_port, end_port)

# Sonuçları yazdır
#for result in scan_results:
#    print(f"IP: {result[0]}\tPort: {result[1]}\tStatus: {result[2]}")
print(scan_results)