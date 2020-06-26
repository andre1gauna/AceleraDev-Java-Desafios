package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private ArrayList<Time> times = new ArrayList<>();
	private ArrayList<Jogador> jogadores = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (times.stream().anyMatch(i -> i.getId().equals(id)))
			throw new IdentificadorUtilizadoException();

		times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (jogadores.stream().anyMatch(i -> i.getId().equals(id)))
			throw new IdentificadorUtilizadoException();

		if (!times.stream().anyMatch(i -> i.getId().equals(idTime)))
			throw new TimeNaoEncontradoException();

		jogadores.add( new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	public void definirCapitao(Long idJogador) {

				buscaTime(buscaJogador(idJogador).getIdTime()).setCapitao(idJogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {

		if(times.stream().filter(i -> i.getId()==idTime).anyMatch(c -> c.getCapitao()==null))
			throw new CapitaoNaoInformadoException();

		return buscaTime(idTime)
				.getCapitao();

	}

	public String buscarNomeJogador(Long idJogador) {
		return buscaJogador(idJogador)
			   .getNome();
	}

	public String buscarNomeTime(Long idTime) {
		return buscaTime(idTime)
		    	.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(!times.stream().anyMatch(i -> i.getId().equals(idTime)))
			throw new TimeNaoEncontradoException();

		return jogadores.stream()
				.filter(i ->i.getIdTime().equals(idTime))
				.map(Jogador::getId)
				.sorted()
				.collect(Collectors.toList());
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		return jogadores.stream()
				.filter(i -> i.getIdTime().equals(idTime))
		        .sorted(Comparator.comparingInt(Jogador::getNivelHabilidade)
				.reversed()
				.thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		return jogadores.stream()
				.filter(i -> i.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getDataNascimento)
				.thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);
	}

	public List<Long> buscarTimes() {
		return times.stream()
				.sorted(Comparator.comparingLong(Time::getId))
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {

		return jogadores.stream()
				.filter(i -> i.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getSalario)
				.reversed()
				.thenComparingLong(Jogador::getId))
				.map(Jogador::getId)
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return buscaJogador(idJogador).getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores.stream()
			   .sorted(Comparator.comparing(Jogador::getNivelHabilidade)
			   .reversed()
			   .thenComparingLong(Jogador::getId))
			   .limit(top)
			   .mapToLong(Jogador::getId)
		    	.boxed()
				.collect(Collectors.toList());
	}

	private Jogador buscaJogador(Long idJ)
	{
		return jogadores.stream()
				.filter(i -> i.getId().equals(idJ))
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);
	}
	private Time buscaTime(Long idT)
	{
		return times.stream()
				.filter(i -> i.getId().equals(idT))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);
	}
}
