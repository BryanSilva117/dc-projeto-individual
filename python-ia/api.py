from models import gerador_textos
from functions import functions
import requests
import json
import os
import re
from dotenv import load_dotenv

load_dotenv()

def buscador(nome):
    nome_formated = nome.title()
    
    link_busca = f"http://localhost:8080/personagens/personagem-por-nome/{nome_formated}"
    token_temp = os.environ.get("TOKEN_TEMP_SPRING")
    headers = {"Authorization": f"Bearer {token_temp}"  ,"Content-Type": "application/json"}
    
    try:
        requisicao_nome = requests.get(link_busca, headers=headers)
        if requisicao_nome.status_code == 200:
            print(f"Personagem {nome_formated} já cadastrado.")
            return requisicao_nome.json()
        else:
            print("Personagem não encontrado.")       
    except Exception as e:
        print(f"Erro ao acessar a API: {e}")
    
    
    resposta = gerador_textos.gerador_text(nome)

    if resposta == "Heroi não encontrado":
        print(resposta)
    else:    
        padrao_nomes = r"!!(.*?)!!"
        resultados = re.findall(padrao_nomes, resposta)
        
        results_clear = functions.remove_same_names(resultados)
        
        personagem = []
        
        if len(results_clear) == 0:
            results_clear.append(nome)
            
        print(results_clear)
        print(resposta)
        
        
        exits_perso = []
        
        
        for resultado in results_clear:
                
            if len(exits_perso) >= 2:
                break
            
            link_busca = f"http://localhost:8080/personagens/personagem-por-nome/{resultado}"
            
            try:
                requisicao_nome = requests.get(link_busca, headers=headers)
                if requisicao_nome.status_code == 200:
                    exits_perso.append(1)
                    print(f"Personagem {resultado} já cadastrado.")
                    personagem.append(requisicao_nome.json())
                else:
                    exits_perso.append(0)
                        
            except Exception as e:
                print(f"Erro ao acessar a API: {e}")
                
                    
        
        
        if exits_perso[0] != 1 or exits_perso[1] != 1:
            personagem = None
            
            personagem = {
                "nome": results_clear[1],
                "origem": resposta,
                "foto": f"{results_clear[1]}.jpg",
                "nomesAlternativos": results_clear
            }
            
            link_spring = "http://localhost:8080/personagens"
            personagem = json.dumps(personagem)
            
            try:
                requisicao = requests.post(link_spring, headers=headers, data=personagem)
            except Exception as e:
                print(f"Erro ao acessar a API: {e}")
            
            return requisicao.json()
        else:
            return personagem