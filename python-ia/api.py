from models import gerador_textos
from functions import functions
import requests
import json
import os
import re
from dotenv import load_dotenv

load_dotenv()


resposta = gerador_textos.gerador_text("Superman")

if resposta == "Heroi não encontrado":
    print(resposta)
else:    
    padrao_nomes = r"!!(.*?)!!"
    resultados = re.findall(padrao_nomes, resposta)
    print(resultados)
    
    results_clear = functions.remove_same_names(resultados)
    
    token_temp = os.environ.get("TOKEN_TEMP_SPRING")
    headers = {"Authorization": f"Bearer {token_temp}"  ,"Content-Type": "application/json"}
    
    personagem = None
    
    for resultado in results_clear:
        link = f"http://localhost:8080/personagens/personagem-por-nome/{resultado}"
        
        try:
            requisicao_nome = requests.get(link, headers=headers)
            if requisicao_nome.status_code == 200:
                print(f"Personagem {resultado} já cadastrado.")
                personagem = requisicao_nome.json()
                break
        except Exception as e:
            print(f"Erro ao acessar a API: {e}")
            
    print(personagem)
    
    if personagem is None:
        personagem = {
            "nome": resultados[0],
            "origem": resposta,
            "foto": f"{resultados[0]}.jpg",
            "nomesAlternativos": resultados
        }
        
        link_spring = "http://localhost:8080/personagens"
        personagem = json.dumps(personagem)
        
        try:
            requisicao = requests.post(link_spring, headers=headers, data=personagem)
        except Exception as e:
            print(f"Erro ao acessar a API: {e}")
        
        print(requisicao.status_code)