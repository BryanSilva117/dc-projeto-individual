from fastapi import FastAPI
from api import buscador


app = FastAPI()

@app.get("/buscar_personagem/{hero}")
def buscar_personagem(hero: str):
    personagem = buscador(hero)
    return personagem