import requests
import json
import os
from dotenv import load_dotenv

load_dotenv(override=True)


API_KEY = os.environ.get("KEY_GOOGLE")
ID = os.environ.get("ID_SEARCH_IMAGES")

def buscar_imagens(termo):
    url = f"https://www.googleapis.com/customsearch/v1"
    termo_comp = f"DC wallpaper {termo}"
    params = {
        "q": termo_comp,               
        "cx": ID,                
        "key": API_KEY,           
        "searchType": "image",   
        "num": 3, 
        "start": 1
    }

    try:
        resposta = requests.get(url, params=params)
    
        if resposta.status_code == 200:
            dados = resposta.json()
            imagens = [item["link"] for item in dados.get("items", [])]
            return imagens
        else:
            print("Erro ao buscar imagens:", resposta.text)
            return []
    except Exception as e:
        print("Erro ao buscar imagens:", str(e))
        return []