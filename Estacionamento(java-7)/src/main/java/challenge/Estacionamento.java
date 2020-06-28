package challenge;

import java.util.*;
import java.util.stream.Collectors;

public class Estacionamento {

    private final int quantVagas = 10;

    ArrayList<Carro> estacionados;

    public Estacionamento(){
        estacionados = new ArrayList<>();
    }

    public void estacionar(Carro carro) {

        if(estacionados.size() < quantVagas)
            estacionados.add(carro);
        else
            estacionados = expulsaMaisAntigo(estacionados, carro);
    }

    public int carrosEstacionados() {
        return estacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return estacionados.contains(carro);
    }

    private static ArrayList<Carro> expulsaMaisAntigo(ArrayList<Carro> estacionados, Carro carro)
    {
        ArrayList<Carro> EstacionadosOrdenados = estacionados.stream()
                .sorted(Comparator.comparing(Carro::getData))
                .collect(Collectors.toCollection(ArrayList::new));

        for (Carro car : EstacionadosOrdenados)
        {
            if(car.getMotorista().getIdade()>=55)
                continue;
            else {
                estacionados.remove((car));
                estacionados.add(carro);
                return estacionados;
            }
        }

        throw new EstacionamentoException("Estacionamento lotado!");
    }
}
