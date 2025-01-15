from models import gerador_textos
import requests
import json
import os
import re
from dotenv import load_dotenv

load_dotenv()


resposta = gerador_textos.gerador_text("Shazam!")

if resposta == "Heroi não encontrado.":
    print(resposta)
else:
    padrao_nomes = r"!!(.*?)!!"
    resultados = re.findall(padrao_nomes, resposta)
    print(resultados)