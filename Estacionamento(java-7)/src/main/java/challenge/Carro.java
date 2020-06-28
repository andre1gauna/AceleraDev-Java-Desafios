package challenge;

import java.util.Date;
import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private final int dataEstacionado;

    private static Date data = new Date();

    private Carro(Motorista motorista, String placa, Cor cor, int dataEstacionado) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
        this.dataEstacionado = dataEstacionado;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public long getData() {
        return dataEstacionado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private Date dataEstacionado;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        public Carro build() {
            validaCarro();
            return new Carro(motorista, placa, cor, (int)((data.getTime()-1593375183797l))/10);
        }

        private void validaCarro() {

            if (placa == null || cor == null)
                throw new NullPointerException();
            if (motorista == null)
                throw new EstacionamentoException("O carro não se dirige sozinho!");


        }
    }
}
