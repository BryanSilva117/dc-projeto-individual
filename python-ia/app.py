from fastapi import FastAPI
from functions import run_model
from functions.objeto import Personagem


app = FastAPI()

@app.get("/buscar_personagem/{perso}")
def buscar_personagem(perso: str):
    personagem = run_model.buscador(perso)
    return personagem


    
@app.post("/cadastrar_personagem")
def cadastrar_personagem(personagem : Personagem):
    personagem = run_model.cadastrar_personagem(personagem)
    return personagem

