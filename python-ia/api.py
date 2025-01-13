from models import gerador_textos
import requests
import json
import os
from dotenv import load_dotenv

load_dotenv()


resposta = gerador_textos.gerador_text("")

print(resposta)