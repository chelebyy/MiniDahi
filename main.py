from fastapi import FastAPI, HTTPException

app = FastAPI()

@app.get("/categories/colors")
async def get_colors():
    try:
        return {"colors": ["Kırmızı", "Mavi", "Yeşil", "Sarı"]}  # örnek veri
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e)) 