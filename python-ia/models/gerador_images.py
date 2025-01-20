import requests
import json
import os
from dotenv import load_dotenv

load_dotenv()

api_key = os.environ.get("API_KEY")
if not api_key:
    raise ValueError("Token da API não encontrado. Verifique o arquivo .env e a variável API_KEY.")

endpoint = "https://api.openai.com/v1/images/generations"



def gerar_img(nome):
    data = {
    "prompt": f"faça uma foto do corpo completo do seguinte herói: {nome}",
    "n": 1,
    "size": "1024x1024",
    }

    # Cabeçalhos para a requisição
    headers = {
        "Authorization": f"Bearer {api_key}",
        "Content-Type": "application/json",
    }
    
    # Faz a requisição
    try:
        response = requests.post(endpoint, json=data, headers=headers)
        # Verifica e exibe o resultado
        if response.status_code == 200:
            image_url = response.json()["data"][0]["url"]
            print(f"URL da imagem gerada: {image_url}")
        else:
            print(f"Erro ao gerar imagem: {response.status_code}")
        print(response.json())
    except Exception as e:
        print(f"Erro ao acessar a API: {e}")