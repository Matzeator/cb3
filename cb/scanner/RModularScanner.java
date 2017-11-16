package cb.scanner;

import uni_bayreuth.ai6.compiler.exceptions.LexicalAnalysisException;
import uni_bayreuth.ai6.compiler.exercises.interfaces.Scanner;
import uni_bayreuth.ai6.exercises.submission.Authors;
import uni_bayreuth.ai6.exercises.submission.ISubmission;
import uni_bayreuth.ai6.exercises.submission.Student;
import uni_bayeruth.ai6.compiler.exercises.conextfreegrammer.StdToken;
import uni_bayreuth.ai6.compiler.exercises.ws17_18.exercise3.Terminals;


public class RModularScanner implements Scanner, ISubmission {
    private String inputString = "";
    private char[] input;
    private int pos = 0;
    private StdToken nextStdToken = null;
    private LexicalAnalysisException exception = null;

    @Override
    public void setInput​(java.lang.String input) {
        this.input = inputString.toCharArray();
        this.nextToken = null;
        this.exception = null;
        try{
            this.nextToken = this.getNextToken();
        } catch (LexicalAnalysisException ex1) {
            this.exception = ex1;
        }
    }

    public boolean isAtEndOfInput() {
        if(this.input.length() <= this.pos){
            return true;
        }
        else {
            return false;
        }
    }

    public StdToken findToken() throws LexicalAnalysisException {
        if(this.isAtEndOfInput()){
            throw new LexicalAnalysisException("Eingabestring ist zueende");
        }
        else {
            while(pos < inputString.length()) {
                if (input[pos] == '+' && (inputString.length() < pos + 1 || input[pos + 1] == ' ' || input[pos + 1] == '\n'))
                    return Terminals.plus;
                if (input[pos] == '*' && (inputString.length() < pos + 1 || input[pos + 1] == ' ' || input[pos + 1] == '\n'))
                    return Terminals.times;
                if (input[pos] == '(' && (inputString.length() < pos + 1 || input[pos + 1] == ' ' || input[pos + 1] == '\n'))
                    return Terminals.open_bracket;
                if (input[pos] == ')' && (inputString.length() < pos + 1 || input[pos + 1] == ' ' || input[pos + 1] == '\n'))
                    return Terminals.close_bracket;

                if (pos + 1 < inputString.length() && (inputString.length() < pos + 1 || input[pos + 1] == ' ' || input[pos + 1] == '\n')) {
                    if (input[pos] == ':') {
                        if (input[pos + 1] == '=')
                            return Terminals.colon_equal;
                    }
                    if (input[pos] == 'f') {
                        if (input[pos + 1] == 'i')
                            return Terminals.fi;
                    }

                    if (input[pos] == 'd') {
                        if (input[pos + 1] == 'o') {
                            return Terminals.do_;
                        }
                    }
                    if (input[pos] == 'o') {
                        if (input[pos + 1] == 'd') {
                            return Terminals.od;
                        }
                    }
                    if (input[pos] == 'i') {
                        if (input[pos + 1] == 'd')
                            return Terminals.id;
                        if (input[pos + 1] == 'f')
                            return Terminals.if_;
                    }
                }
                if (pos + 2 < inputString.length() && (inputString.length() < pos + 1 || input[pos + 1] == ' ' || input[pos + 1] == '\n')) {
                    if (input[pos] == 'c') {
                        if (input[pos + 1] == 'o') {
                            if (input[pos + 2] == 'p') {
                                return Terminals.cop;
                            }
                        }
                    }

                }
                if (pos + 3 < inputString.length() && (inputString.length() < pos + 1 || input[pos + 1] == ' ' || input[pos + 1] == '\n')) {
                    if (input[pos] == 't') {
                        if (input[pos + 1] == 'h') {
                            if (input[pos + 2] == 'e') {
                                if (input[pos + 3] == 'n') {
                                    return Terminals.then;
                                }
                            }
                        }
                    }
                    if (input[pos] == 'e') {
                        if (input[pos + 1] == 'l') {
                            if (input[pos + 2] == 's') {
                                if (input[pos + 3] == 'e') {
                                    return Terminals.else_;
                                }
                            }
                        }
                    }
                }
                if (pos + 4 < inputString.length() && (inputString.length() < pos + 1 || input[pos + 1] == ' ' || input[pos + 1] == '\n')) {
                    if (input[pos] == 'c') {
                        if (input[pos + 1] == 'o') {
                            if (input[pos + 2] == 'n') {
                                if (input[pos + 3] == 's') {
                                    if (input[pos + 4] == 't') {
                                        return Terminals.const_;
                                    }
                                }
                            }
                        }
                    }
                    if (input[pos] == 'w') {
                        if (input[pos + 1] == 'h') {
                            if (input[pos + 2] == 'i') {
                                if (input[pos + 3] == 'l') {
                                    if (input[pos + 4] == 'e') {
                                        return Terminals.while_;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    pos++;
                }
            }
            return null;

        }
    }



    @Override Token getNextToken() throws LexicalAnalysisException {
        if(this.nextToken == null) {
            throw new LexicalAnalysisException("Keine StdToken uebrig");
        }
        else {
            StdToken newToken = this.nextToken;
            this.nextToken = null;
            this.nextToken = this.findToken();
            return this.nextToken;
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
        return authors;
    }

}
