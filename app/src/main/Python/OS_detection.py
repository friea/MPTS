from scapy.all import *
from scapy.layers.inet import IP, ICMP



def os(ip):
	os = ''
	paket = IP(dst=ip)/ICMP()
	cevap = sr1(paket, timeout=3)
	if cevap:
    		if IP in cevap:
        		ttl = cevap.getlayer(IP).ttl
        		if ttl <= 64: 
            			os = 'Linux'
						return '\n\nTTL = {ttl} \n*{os}* İşletim sistemi tespit edildi. \n\n'
        		elif ttl > 64:
            			os = 'Windows'
						return '\n\nTTL = {ttl} \n*{os}* İşletim sistemi tespit edildi. \n\n'
        		else:
            			print('Bulunamadı')
						return "Bulunamadı"
        		print(f'\n\nTTL = {ttl} \n*{os}* İşletim sistemi tespit edildi. \n\n')