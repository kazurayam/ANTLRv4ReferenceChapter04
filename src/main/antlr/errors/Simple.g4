/**
 * "The Definitive ANTLR 4 Reference" book
 * Chapter 9 Error Reporting and Recovery
 */
grammar Simple;

prog
    :   classDef+   // one or more class definitions
    ;

classDef
    :   'class' ID '{' member+ '}'      // a class has one or more members
        { System.out.println("class " + $ID.text); }
    ;

member
    :   'int' ID ';'                            // field definition
        { System.out.println("var " + $ID.text); }
    |   'int' f=ID '(' ID ')' '{' stat '}'      // method definition
        { System.out.println("method: " + $f.text); }
    ;

stat
    :   expr ';'
        { System.out.println("found expr: " + $expr.text); }
    |   ID '=' expr ';'
        { System.out.println("found assign: " + $ID.text + "=" + $expr.text); }
    ;

expr
    :   INT
    |   ID '(' INT ')'
    ;

INT :   [0-9]+ ;
ID  :   [a-zA-Z]+ ;
WS  :   [ \t\r\n]+ -> skip ;
