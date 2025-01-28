from pydantic import BaseModel
from typing import List

class Personagem(BaseModel):
    nome: str
    origem: str
    foto: str
    nomesAlternativos: List[str]