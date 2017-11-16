package cb.scanner;

import uni_bayreuth.ai6.compiler.exceptions.LexicalAnalysisException;
import uni_bayreuth.ai6.compiler.exercises.interfaces.Scanner;
import uni_bayreuth.ai6.exercises.submission.Authors;
import uni_bayreuth.ai6.exercises.submission.ISubmission;
import uni_bayreuth.ai6.exercises.submission.Student;
import uni_bayeruth.ai6.exercises.conextfreegrammer.StdToken;


public class RModularScanner implements Scanner, ISubmission {
    private String inputString = "";
    private char[] input;
    private int pos = 0;
    private Token nextToken = null;
    private LexicalAnalysisException exception = null;

    @Override
    public void setInput​(java.lang.String input) {
        this.input = inputString.toCharArray();
        this.nextToken = null;
        this.exception = null;
        try{
            this.nextToken = this.getnNextToken();
        } catch (LexicalAnalysisException ex1) {
            this.exception = ex1;
        }
    }

    public boolean isAtEndOfInput {
        if(this.pos == this.input.length()){
            return true;
        }
        else {
            return false;
        }
    }

    public Token findToken() throws LexicalAnalysisException {
        if(this.isAtendOfInput()){
            throw new LexicalAnalysisException("Eingabestring ist zueende");
        }
        else {
            if (input[pos] == '+')
                return Terminals.plus;
            if (input[pos] == '*')
                return Terminals.times;
            if (input[pos] == '(')
                return Terminals.open_bracket;
            if (input[pos] == ')')
                return Terminals.close_bracket;
            if (input[pos] == ':'){
                if (input[pos + 1] == '=')
                    return Terminals.colon_equal;
             }
            if(input[pos] == 'i'){
                if(input[pos + 1] == 'd')
                    return Terminals.id;
                if(input[pos + 1] == 'f')
                    return Terminals.if
            }



        }
    }



    @Override Token getNextToken() throws LexicalAnalysisException {
        if(this.nextToken == null) {
            throw new LexicalAnalysisException("Keine Token uebrig");
        }
        else {
            Token newToken = this.nextToken;
            this.nextToken = null;

            try {
                this.nextToken = this.findToken();
                this.exception = null;
            } catch(LexicalAnalysisException ex2) {
                this.exception = ex2;
            }

        }
        return null;
    }

    public RModularScanner() {
    }

    public static Scaner getInstance() {
        return new RModularScanner();
    }

    @Override
    public Authors getInformation() {
        Authors authors = new Authors();
        authors.addAuthor(new Student("Matthias", "Babel", "s1mababe@uni-bayreuth.de", 1394333));
        authors.addAuthor(new Student("Felix", "Nickels", "s1fenick@uni-bayreuth.de", 1383344));
        return authors
    }

}
