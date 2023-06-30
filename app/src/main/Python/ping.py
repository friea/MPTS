#!/usr/bin/python
from scapy.all import *
def ping( ip):
	TIMEOUT = 3
	conf.verb = 0
   	paket = IP(dst=ip, ttl=20)/ICMP()
    	cevap = sr1(paket, timeout=TIMEOUT)
    	if not (cevap is None):
         	print cevap.dst, " aktif"
			return "IP şuan aktiftir."
    	else:
         	print "%s -> Zaman aşımı" %paket[IP].dst
			return "IP aktif değildir."
