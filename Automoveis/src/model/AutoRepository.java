package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AutoRepository {
    private final String arquivo = "automoveis.txt";

    public void salvarLista(List<Auto> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
	public List<Auto> carregarLista() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Auto>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}