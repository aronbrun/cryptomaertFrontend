from coinbase.wallet.client import Client
from api_models import BuyOrder
import main

def buy_coins(order: BuyOrder):
    coins = sat_to_coins(order.satoshis)

    client = Client("4Mf2j413XB7qNl3V", "0e1wuPN2MaDDPTQdZUQMonxLaJ3zSael")

    pms = client.get_payment_methods()

    buy = client.buy('2bbf394c-193b-5b2a-9155-3b4732659ede',
                     amount=coins,
                     currency="BTC",
                     payment_method=pms)

    tx = client.send_money('2bbf394c-193b-5b2a-9155-3b4732659ede',
                           to=order.address,
                           amount=coins,
                           currency='BTC',
                           idem='9316dd16-0c05')


def sat_to_coins(satoshis):
    return satoshis / 100_000_000


main.set_buy_func(buy_coins)
