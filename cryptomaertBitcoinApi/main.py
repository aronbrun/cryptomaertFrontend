from typing import Callable, Union

from fastapi import FastAPI, HTTPException

from api_models import BuyOrder

app = FastAPI()
buy_func: Union[Callable[[BuyOrder], None], None] = None


@app.post('/buy')
def process_order(order: BuyOrder):
    if buy_func:
        buy_func(order)
    else:
        raise HTTPException(501, 'The service has not yet been initialized correctly. Please set up the buy function')


def set_buy_func(func: Callable[[BuyOrder], None]):
    global buy_func
    buy_func = func

import OnSuccess