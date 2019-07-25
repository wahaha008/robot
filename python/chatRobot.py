import itchat
import requests
import random
def get_response(msg):
    apiUrl = 'http://192.168.113.122:9999/robot/answer/' + msg

    r = requests.get(apiUrl).json()
    response = r.get('data').get(msg)
    print(random.choice(response))
    return random.choice(response)

@itchat.msg_register(itchat.content.TEXT, isGroupChat = False)
def print_content(msg):

    print(msg['Text'])
    return get_response(msg['Text'])

# @itchat.msg_register([itchat.content.TEXT], isGroupChat=True)
# def print_content(msg):
#
#     print(msg)
#     return get_response(msg['Text'])

itchat.auto_login(True)
itchat.run()