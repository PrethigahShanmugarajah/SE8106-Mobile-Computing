import socket
import threading

HOST = "127.0.0.1"
PORT = 12345


def receive_messages(client):
    while True:
        try:
            message = client.recv(1024).decode()

            if not message or message.lower() == "exit":
                print("\nServer disconnected.")
                break

            print(f"\nServer: {message}")

        except:
            break

    client.close()


client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client.connect((HOST, PORT))

print("Connected to the server!")

receive_thread = threading.Thread(
    target=receive_messages,
    args=(client,),
    daemon=True
)

receive_thread.start()

while True:
    message = input("Client: ")

    try:
        client.send(message.encode())

        if message.lower() == "exit":
            print("Client disconnected.")
            break

    except:
        print("Connection closed.")
        break

client.close()
