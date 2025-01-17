import requests
import os
from dotenv import load_dotenv

# Carrega as variáveis de ambiente
load_dotenv()

# Chave de API da OpenAI
api_key = os.getenv("API_KEY")
endpoint = "https://api.openai.com/v1/images/generations"

# Prompt para a imagem
hero = "Shazam!"
data = {
    "prompt": f"faça uma foto do corpo completo do seguinte herói: {hero}",
    "n": 1,
    "size": "1024x1024",
}

# Cabeçalhos para a requisição
headers = {
    "Authorization": f"Bearer {api_key}",
    "Content-Type": "application/json",
}

# Faz a requisição
response = requests.post(endpoint, json=data, headers=headers)

# Verifica e exibe o resultado
if response.status_code == 200:
    image_url = response.json()["data"][0]["url"]
    print(f"URL da imagem gerada: {image_url}")
else:
    print(f"Erro ao gerar imagem: {response.status_code}")
    print(response.json())
