package br.com.pb_quiz.aplicacao;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.pb_quiz.dao.QuestaoDao;
import br.com.pb_quiz.dao.ResultadoDao;
import br.com.pb_quiz.modelo.Questao;
import br.com.pb_quiz.modelo.Resultado;
import br.com.pb_quiz.util.JPAUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int entradaMenu = 0;

		do {
			System.out.println();
			System.out.println("Digite a op??o desejada: ");
			System.out.println("1 - Jogar Novamente");
			System.out.println("2 - Ver placar");
			System.out.println("0 - Sair");

			entradaMenu = sc.nextInt();
			switch (entradaMenu) {
			case 1:
				System.out.println("---------- Iniciando o jogo ----------");
				quiz();
				break;
			case 2:
				System.out.println("---------- Placar ----------");
				placar();
				break;
			case 0:
				System.out.println("---------- Obrigado por jogar! ----------");
				break;
			default:
				System.out.println("Op??o inv?lida");
			}

		} while (entradaMenu != 0);

	}

	private static void quiz() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		EntityManager em = JPAUtil.getEntityManager();
		Resultado resultado = new Resultado();
		System.out.println("Digite seu nome: ");
		resultado.setNome(sc.nextLine());
		while (resultado.getNome().isBlank()) {
			System.out.println("Nome inv?lido, digite novamente.");
			resultado.setNome(sc.nextLine());
		
		}
		
		resultado.setAcertos(0);
		resultado.setErros(0);
		QuestaoDao qDao = new QuestaoDao(em);
		List<Questao> questoes = qDao.questoesAtivas();
		questoes.forEach(p -> {

			System.out.println("Responda com verdadeiro ou falso -> " + p.getPergunta());
			System.out.println("Insira a resposta: ");

			String respostaUsuario = sc.nextLine();

			if (respostaUsuario != "verdadeiro" || respostaUsuario != "falso") {
				int aux = 1;
				while (aux == 1) {

					if ("verdadeiro".equals(respostaUsuario) || "falso".equals(respostaUsuario)) {
						aux = 2;
					}

					else {
						System.out.println("Resposta inv?lida, tente novamente");
						respostaUsuario = sc.nextLine();
					}
				}

				boolean respostaBoolean = true;

				if ("verdadeiro".equals(respostaUsuario)) {
					respostaBoolean = true;
					if (respostaBoolean == p.isVerdadeira()) {
						resultado.setAcertos(resultado.getAcertos() + 1);
						System.out.println("Voc? acertou!");
					} else {
						resultado.setErros(resultado.getErros() + 1);
						System.out.println("Voc? errou!");
					}
				} else if ("falso".equals(respostaUsuario)) {
					respostaBoolean = false;
					if (respostaBoolean == p.isVerdadeira()) {
						resultado.setAcertos(resultado.getAcertos() + 1);
						System.out.println("Voc? acertou!");
					} else {
						resultado.setErros(resultado.getErros() + 1);
						System.out.println("Voc? errou!");
					}
				} else {
					System.out.println("Erro na digita??o do jogo!");
				}

				System.out.println("---------------------------------------------");
				System.out.println();
			}
		});
		ResultadoDao resultadoDao = new ResultadoDao(em);

		em.getTransaction().begin();
		resultadoDao.cadastrar(resultado);

		em.getTransaction().commit();
		
	}

	private static void placar() {
		// TODO Auto-generated method stub7
		EntityManager em = JPAUtil.getEntityManager();
		ResultadoDao resultadoDao = new ResultadoDao(em);
		List<Resultado> listagem = resultadoDao.ranking();
		listagem.forEach( p -> {
		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataFormatada = p.getDataPartida().format(formatter);
			System.out.println("JOGADOR: " + p.getNome() + " ACERTOS: "+ p.getAcertos() + " ERROS: " + p.getErros() + " DATA: "+ dataFormatada);
			
		});
	}

}
