// 1-pacote
package petloja;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

//2-biblioteca
//3-classe
public class Pet {
//3.1- atributos

//(url é uri) endereço da entidade pet

    String uri = "https://petstore.swagger.io/v2/pet";



// 3.2 - metodos e função  // aprimeira minuscula a segunda maiscula,poe o parentece e abre a chave
public String lerJson (String caminhoJson) throws IOException {
  //******  //como vai mudar sempre a validação põe a string de caminho
return new String(Files.readAllBytes(Paths.get(caminhoJson)));



}

////Incluir// -create -post******

    //indentificar o metodo ou funçao para um test testng*********
    @Test
    public void incluirPet() throws IOException {
        String jsonBody =lerJson("dados/pet1.json");

        //sintaxe Gherkin // Dado // Quando // Então em ingles Given/when/then

        given ()
                //com api rest novas, antigas era "text/xml"****
        .contentType ( "application/json")
        .log().all()
                .body(jsonBody)
                .when()
                .post(uri)
                .then()
                .log().all()
                .statusCode(200)
                ;

    }



}
