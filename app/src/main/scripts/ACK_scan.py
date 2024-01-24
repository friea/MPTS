# -*- coding: utf-8 -*-
"""
@author: metis
"""

import threading
import socket

def xmas_scan(target_ip, target_port, result_list, open_list):
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.settimeout(1)

    try:
        sock.connect((target_ip, target_port))
        sock.send(b"\x10")
        response = sock.recv(1024)

        if not response:
            result_list.append((target_ip, target_port, "open"))
            open_list.append(target_port)
        else:
            result_list.append((target_ip, target_port, "closed"))
    except socket.error:
        result_list.append((target_ip, target_port, "open"))
        open_list.append(target_port)
    finally:
        sock.close()

def XMAS_total(target_ip, start_port, end_port):
    result_list = []
    threads = []
    open_list = []

    for port in range(start_port, end_port + 1):
        thread = threading.Thread(target=xmas_scan, args=(target_ip, port, result_list,open_list))
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

scan_results = XMAS_total(target_ip, start_port, end_port)

# Sonuçları yazdır
print(scan_results)
