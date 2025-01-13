import requests
import json
import os
from dotenv import load_dotenv

load_dotenv()

api_key = os.environ.get("API_KEY")
headers = {"Authorization": f"Bearer {api_key}", "Content-Type": "application/json"}
link = "https://api.openai.com/v1/chat/completions"
id_model = "gpt-4o-mini"


def gerador_text(hero):

    body_msg = {
        "model": id_model,
        "messages": [
            {
                "role": "system",
                "content": (
                    "Você é um redator especializado em criar conteúdo para um site sobre heróis da DC Comics. "
                    "Sua missão é fornecer informações detalhadas sobre o herói mencionado pelo usuário, "
                    "incluindo uma introdução, origem, poderes e curiosidades. O tom deve ser envolvente, "
                    "informativo e acessível, como em um blog ou site de cultura pop."
                )
            },
            {
                "role": "user",
                "content": hero
            }
        ]
    }
    body_msg = json.dumps(body_msg)

    requisicao = requests.post(link, headers=headers, data=body_msg)
    resposta = requisicao.json()
    mensagem = resposta["choices"][0]["message"]["content"]
    
    return mensagem

