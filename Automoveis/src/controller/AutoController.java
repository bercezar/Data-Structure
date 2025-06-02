package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Auto;

public class AutoController {
	
	private ArrayList<Auto> autos = new ArrayList<>();
	
	public String incluir(Auto novoAuto) {
		for (Auto auto : autos) {
			if (auto.getPlaca().equalsIgnoreCase(novoAuto.getPlaca())) {
				return "Erro (=@#/) -- Automóvel já existe -- .";
			}
		}
		autos.add(novoAuto);
		return "Automóvel incluído com sucesso";
	}
	
	public String excluir(Auto autoSelecionado) {
		for (Auto auto : autos) {
			if (auto.getPlaca().equalsIgnoreCase(autoSelecionado.getPlaca())) {
				autos.remove(auto);
				return "Automóvel excluído com sucesso";
			}
		}
		return "Erro (=@#/) -- Automóvel não existe -- .";
	}
	
	public Auto consultar(Auto autoSelecionado) {
		for (Auto auto :  autos) {
			if (auto.getPlaca().equalsIgnoreCase(autoSelecionado.getPlaca())) {
				return auto;
			}
		}
		return null;

	}
	public String alterar(String placa, Auto autoAtualizado) {
	    for (Auto auto : autos) {
	        if (auto.getPlaca().equalsIgnoreCase(placa)) {
	            auto.setModelo(autoAtualizado.getModelo());  
	            auto.setMarca(autoAtualizado.getMarca());  
	            auto.setAno(autoAtualizado.getAno());
	            return "Automóvel atualizado com sucesso.";
	        }
	    }

	    return "Erro (=@#/) -- Automóvel não existe -- .";
	}
	
	public List<Auto> listarPorAno() {
	    List<Auto> listaOrdenada = new ArrayList<>(autos);
	    Collections.sort(listaOrdenada, Comparator.comparingInt(Auto::getAno));
	    return listaOrdenada;
	}
	
}
