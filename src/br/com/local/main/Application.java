package br.com.local.main;
import br.com.local.models.ProductClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    static void main() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("digite o nome do produto: ");
        var nome = scanner.nextLine();
        while (nome.isBlank()){
            System.out.println("O campo não pode estar vazio, digite novamente!");
            nome = scanner.nextLine();
        }

        System.out.println("Digite uma curta descrição: ");
        var descricao = scanner.nextLine();
        while (descricao.isBlank()){
            System.out.println("O campo não pode estar vazio, digite novamente!");
            descricao = scanner.nextLine();
        }

        System.out.println("Digite o valor do produto");

        while(!scanner.hasNextDouble()){
            System.out.println("O valor é inválido, digite novamente!");
            scanner.next();
        }

        var valor = scanner.nextDouble();

        while(valor <= 0){
            System.out.println("O valor deve ser maior que 0, digite novamente!");
            scanner.nextDouble();
        }

        System.out.println("Digite a quantidade no estoque");

        while(!scanner.hasNextInt()){
            System.out.println("O valor é inválido, digite novamente!");
            scanner.next();
        }

        var quantidade = scanner.nextInt();

        ProductDTO produto = new ProductDTO(nome, descricao, valor, quantidade);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                        .create();

        try(BufferedWriter escrita = new BufferedWriter(new FileWriter(nome + ".json"))) {
            escrita.write(gson.toJson(produto));
            System.out.println("O arquivo JSON foi criado!");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo" + e.getMessage());
        }

        System.out.println("objeto criado: \n" + produto.toString());

    }
}
