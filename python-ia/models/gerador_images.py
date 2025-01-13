from openai import OpenAI
import os
from dotenv import load_dotenv

load_dotenv()

OpenAI.api_key = os.getenv("API_KEY")

hero = "Shazam!"

client = OpenAI()
response = client.images.generate(
    model="dall-e-3",
    prompt=f"faça uma foto do corpo completo do seguinte heroi: {hero}",
    size="1024x1024",
    quality="standard",
    n=1,
)

print(response.data[0].url)