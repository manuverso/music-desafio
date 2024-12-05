package br.com.alura.sfmusic.services;


import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaGemini {


    public static String obterInformacao(String nome) {
        // Inicializa o serviço Gemini com a chave da API
        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_APIKEY"))
                .modelName("gemini-1.5-flash")
                .build();

        // Cria a requisição
//        CompletionRequest requisicao = CompletionRequest.builder()
//                .model("gemini-1.5-flash")
//                .prompt("me fale sobre o artista: " + texto)
//                .maxTokens(1000)
//                .temperature(0.7)
//                .build();

        // Envia a requisição e obtém a resposta
        String response = gemini.generate("me fale sobre o artista: " + nome);


//        CompletionResponse resposta = service.createCompletion(requisicao);



        // Retorna o texto da primeira escolha
        return response;


//        return resposta.getChoices().get(0).getText();
    }
}
