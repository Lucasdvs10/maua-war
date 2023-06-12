package Model.mock;

import domain.entities.Question;

import java.util.ArrayList;
import java.util.Random;

public class QuestionDAOMock implements Model.IQuestionDAO{
    private ArrayList<Question> _questionsDBMock;

    @Override
    public void RegisterQuestion(Question question) {
        this._questionsDBMock.add(question);
    }

    @Override
    public Question GetQuestionById(int questionId) {
        for (Question question : _questionsDBMock) {
            int currentQuestionId = question.get_questionId();

            if (currentQuestionId == questionId)
                return question;
        }
        return null;
    }

    @Override
    public Question GetRandomQuestion() {
        Random random = new Random();

        int randomIndex = random.nextInt(1, this._questionsDBMock.size()+1);

        return GetQuestionById(randomIndex);
    }

    @Override
    public int GetDataBaseSize() {
        return _questionsDBMock.size();
    }

    public ArrayList<Question> get_questionsDBMock() {
        return _questionsDBMock;
    }

    public QuestionDAOMock() {
        this._questionsDBMock = new ArrayList<>();
        this._questionsDBMock.add(new Question("Dado a string 'morangos' salva na variável fruta,\no que o método fruta.substring(2,5) retornaria?", 'A', 1));
        _questionsDBMock.get(0).AddAlternativeToHashMap('A', "ran");
        _questionsDBMock.get(0).AddAlternativeToHashMap('B', "rang");
        _questionsDBMock.get(0).AddAlternativeToHashMap('C', "mogos");
        _questionsDBMock.get(0).AddAlternativeToHashMap('D', "gos");

        this._questionsDBMock.add(new Question("O Diagrama de classes\né um diagrama de qual tipo?", 'B', 2));
        _questionsDBMock.get(1).AddAlternativeToHashMap('A', "De pacotes");
        _questionsDBMock.get(1).AddAlternativeToHashMap('B', "Estrutural");
        _questionsDBMock.get(1).AddAlternativeToHashMap('C', "Comportamental");
        _questionsDBMock.get(1).AddAlternativeToHashMap('D', "Interação");


        this._questionsDBMock.add(new Question("Em qual lingua esse projeto foi feito?", 'D', 3));
        _questionsDBMock.get(2).AddAlternativeToHashMap('A', "C++");
        _questionsDBMock.get(2).AddAlternativeToHashMap('B', "Cobol");
        _questionsDBMock.get(2).AddAlternativeToHashMap('C', "Jython (Sim, essa lingua existe mesmo)");
        _questionsDBMock.get(2).AddAlternativeToHashMap('D', "Java");


        this._questionsDBMock.add(new Question("Como criar uma variavel boleana\nchamada 'isItTrue' em Java?", 'B', 4));
        _questionsDBMock.get(3).AddAlternativeToHashMap('A', "isItTrue = True");
        _questionsDBMock.get(3).AddAlternativeToHashMap('B', "boolean isItTrue;");
        _questionsDBMock.get(3).AddAlternativeToHashMap('C', "let isItTrue: bool = true");
        _questionsDBMock.get(3).AddAlternativeToHashMap('D', "var isItTrue: bool = true");

        this._questionsDBMock.add(new Question("Operação que especifica todas as combinações\npossíveis de duas relações no\nbanco de dados", 'C', 5));
        _questionsDBMock.get(4).AddAlternativeToHashMap('A', "Produto de Codd");
        _questionsDBMock.get(4).AddAlternativeToHashMap('B', "Produto notavel");
        _questionsDBMock.get(4).AddAlternativeToHashMap('C', "Produto Cartesiano");
        _questionsDBMock.get(4).AddAlternativeToHashMap('D', "Produto vetorial");


        this._questionsDBMock.add(new Question("Qual é a empresa responsável\npelo Java hoje?", 'D', 6));
        _questionsDBMock.get(5).AddAlternativeToHashMap('A', "Jetbrains");
        _questionsDBMock.get(5).AddAlternativeToHashMap('B', "Sun");
        _questionsDBMock.get(5).AddAlternativeToHashMap('C', "Microsoft");
        _questionsDBMock.get(5).AddAlternativeToHashMap('D', "Oracle");

        this._questionsDBMock.add(new Question("Como selecionar duas colunas\nem SQL?", 'B', 7));
        _questionsDBMock.get(6).AddAlternativeToHashMap('A', "SELECT * FROM X;");
        _questionsDBMock.get(6).AddAlternativeToHashMap('B', "SELECT A,B FROM X;");
        _questionsDBMock.get(6).AddAlternativeToHashMap('C', "SELECT A AND B FROM X;");
        _questionsDBMock.get(6).AddAlternativeToHashMap('D', "SELECT A FROM X AND SELECT B;");

        this._questionsDBMock.add(new Question("Como selecionar duas colunas\nem SQL?", 'B', 8));
        _questionsDBMock.get(7).AddAlternativeToHashMap('A', "SELECT * FROM X;");
        _questionsDBMock.get(7).AddAlternativeToHashMap('B', "SELECT A,B FROM X;");
        _questionsDBMock.get(7).AddAlternativeToHashMap('C', "SELECT A AND B FROM X;");
        _questionsDBMock.get(7).AddAlternativeToHashMap('D', "SELECT A FROM X AND SELECT B;");

        this._questionsDBMock.add(new Question("O que aparecerá na tela?\nint a = 123451234512345;\nSystem.out.println(a);", 'C', 9));
        _questionsDBMock.get(8).AddAlternativeToHashMap('A', "123451234512345");
        _questionsDBMock.get(8).AddAlternativeToHashMap('B', "Um número com sinal negativo");
        _questionsDBMock.get(8).AddAlternativeToHashMap('C', "Nada, pois não compila");
        _questionsDBMock.get(8).AddAlternativeToHashMap('D', "12345100000");

        this._questionsDBMock.add(new Question("Qual afirmação condiz com\nas formas normais de\nprojeção de banco de dados", 'B', 10));
        _questionsDBMock.get(9).AddAlternativeToHashMap('A', "Atributos devem depender de chaves");
        _questionsDBMock.get(9).AddAlternativeToHashMap('B', "Atributos devem ser atômicos");
        _questionsDBMock.get(9).AddAlternativeToHashMap('C', "Atributos devem ser compreensiveis");
        _questionsDBMock.get(9).AddAlternativeToHashMap('D', "Um atributo pode ser multivalorado");

        this._questionsDBMock.add(new Question("Qual das seguintes linguas\né a mais antiga?", 'A', 11));
        _questionsDBMock.get(10).AddAlternativeToHashMap('A', "Python");
        _questionsDBMock.get(10).AddAlternativeToHashMap('B', "Java");
        _questionsDBMock.get(10).AddAlternativeToHashMap('C', "Kotlin");
        _questionsDBMock.get(10).AddAlternativeToHashMap('D', "Swift");

        this._questionsDBMock.add(new Question("Em um banco de dados\no que é uma relação?", 'B', 12));
        _questionsDBMock.get(11).AddAlternativeToHashMap('A', "O cabeçalho da coluna");
        _questionsDBMock.get(11).AddAlternativeToHashMap('B', "A tabela em si");
        _questionsDBMock.get(11).AddAlternativeToHashMap('C', "Cada linha da tabela");
        _questionsDBMock.get(11).AddAlternativeToHashMap('D', "Tipos de valores de um atributo");

        this._questionsDBMock.add(new Question("Defina a integridade\nde entidade", 'A', 13));
        _questionsDBMock.get(12).AddAlternativeToHashMap('A', "Nenhuma chave primaria pode ser NULL");
        _questionsDBMock.get(12).AddAlternativeToHashMap('B', "Uma tupla deve se referir a outra");
        _questionsDBMock.get(12).AddAlternativeToHashMap('C', "Regras impostas pela aplicação");
        _questionsDBMock.get(12).AddAlternativeToHashMap('D', "Conjunto de valores possíveis de um atributo");

        this._questionsDBMock.add(new Question("Qual palavra-chave define\numa chave primaria?", 'C', 14));
        _questionsDBMock.get(13).AddAlternativeToHashMap('A', "FOREIGN KEY");
        _questionsDBMock.get(13).AddAlternativeToHashMap('B', "UNIQUE");
        _questionsDBMock.get(13).AddAlternativeToHashMap('C', "PRIMARY KEY");
        _questionsDBMock.get(13).AddAlternativeToHashMap('D', "DEFATULT");

    }
}
