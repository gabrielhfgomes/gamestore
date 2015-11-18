/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author s2it_ggomes
 */
public class GamesStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new JFrmMenu().setVisible(true);
        GamesStore m1 = new GamesStore();
        m1.leArquivo("Arquivo.txt");
    }
    
     public void escreveArquivo(String nomeArquivo, boolean b1, int cont) throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nomeArquivo, b1));
        buffWrite.append(String.valueOf(cont));  //no outro pacote
        buffWrite.close();

        System.out.println("Escrito o cont " + cont); //TESTE
    }

    public void leArquivo(String nomeArquivo) throws FileNotFoundException, IOException {
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            escreveArquivo(nomeArquivo, false, 1);
        } else {

            String linha;

            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);
            linha = br.readLine();
            int cont = Integer.parseInt(linha);
            cont++;
            

            escreveArquivo(nomeArquivo, false, cont);
            br.close();
            fr.close();
        }

    }
    
}
