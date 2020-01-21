from pydantic import BaseModel

class BuyOrder(BaseModel):
    address: str
    satoshis: int