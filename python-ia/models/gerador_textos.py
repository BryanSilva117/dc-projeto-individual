import requests
import json
import os
from dotenv import load_dotenv

load_dotenv()
    
def gerador_text(personagem):

    API_KEY = os.environ.get("KEY_GOOGLE")
    CX = os.environ.get("ID_SEARCH_PERSO")
    search_url = "https://www.googleapis.com/customsearch/v1"
   
    params = {
        "q": personagem,               
        "cx": CX,                
        "key": API_KEY,              
        "num": 1
    }

    dados = None

    try:
        resposta = requests.get(search_url, params=params)
    
        if resposta.status_code == 200:
            dados = resposta.json()
        else:
            print("Erro ao buscar personagem:", resposta.text)
            
    except Exception as e:
        print("Erro ao buscar personagem:", str(e))
        


    api_key = os.environ.get("API_KEY")
    if not api_key:
        raise ValueError("Token da API não encontrado. Verifique o arquivo .env e a variável API_KEY.")

    headers = {"Authorization": f"Bearer {api_key}", "Content-Type": "application/json"}
    link = "https://api.openai.com/v1/chat/completions"
    id_model = "gpt-4o-mini"


    body_msg = {
        "model": id_model,
        "messages": [
            {
                "role": "system",
                "content": (
                    "Você é um redator especializado em criar conteúdo para um site sobre personagens da DC Comics."
                    "Sua missão é fornecer informações detalhadas sobre o personagem mencionado pelo usuário"
                    "incluindo uma introdução, origem, poderes e curiosidades. O tom deve ser envolvente"
                    f"Use esses dados do dc_database como base: {dados}"
                    "informativo e acessível, como em um blog ou site de cultura pop."
                    """
                    No começo da resposta, você deve listar os nomes pelos quais o personagem pode ser chamado, sempre seguindo esta ordem:  
                    1. O nome real (alter ego) do personagem primeiro.  
                    2. O nome heroico (ou qualquer outro nome pelo qual ele seja conhecido) depois.  

                    Exemplo de resposta:  
                    !!Bruce Wayne!! !!Batman!!  
                    !!Hal Jordan!! !!Lanterna Verde!!  
                    Nunca repita nomes na lista e siga estritamente essa formatação.
                    """
                    "Se o personagem for de alguma outra editora, você deverá falar isso: Heroi não encontrado."
                )
            },
            {
                "role": "user",
                "content": personagem
            }
        ]
    }
    body_msg = json.dumps(body_msg)

    try:
        requisicao = requests.post(link, headers=headers, data=body_msg)
        resposta = requisicao.json()
        mensagem = resposta["choices"][0]["message"]["content"]
    except Exception as e:
        mensagem = f"Erro ao acessar a API: {e}"
    
    return mensagem

