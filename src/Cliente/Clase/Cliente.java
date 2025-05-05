package Cliente.Clase;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public String enviarNumeros(String IP, int puerto, int n1, int n2, String operacion) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName(IP);

            String mensaje = n1 + "," + n2 + "," + operacion;
            byte[] buffer = mensaje.getBytes();

            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, direccion, puerto);
            socket.send(paquete);

            byte[] bufferRecibido = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(bufferRecibido, bufferRecibido.length);
            socket.receive(paqueteRecibido);

            return new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al comunicarse con el servidor";
        }
    }
}
