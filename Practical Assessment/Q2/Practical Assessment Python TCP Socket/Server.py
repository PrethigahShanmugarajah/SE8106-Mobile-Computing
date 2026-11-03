import socket
import threading

HOST = "127.0.0.1"
PORT = 12345


def receive_messages(client_socket):
    while True:
        try:
            message = client_socket.recv(1024).decode()

            if not message or message.lower() == "exit":
                print("\nClient disconnected.")
                break

            print(f"\nClient: {message}")

        except:
            break

    client_socket.close()


server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server.bind((HOST, PORT))
server.listen(1)

print("Server is waiting for a client...")

client_socket, client_address = server.accept()

print(f"Connected to {client_address}")

receive_thread = threading.Thread(
    target=receive_messages,
    args=(client_socket,),
    daemon=True
)

receive_thread.start()

while True:
    message = input("Server: ")

    try:
        client_socket.send(message.encode())

        if message.lower() == "exit":
            print("Server disconnected.")
            break

    except:
        print("Connection closed.")
        break

client_socket.close()
server.close()
