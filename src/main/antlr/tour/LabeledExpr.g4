grammar LabeledExpr;

@header {
    package tour;
}

import CommonLexerRules;  // include all rules from CommonLexerRules.g4

/**
 * The start rule; begin parsing here
 */
prog: stat+ ;

stat: clear NEWLINE                # clearMem
    | expr NEWLINE                 # printExpr
    | ID '=' expr NEWLINE          # assign
    | NEWLINE                      # blank
    ;

clear: CLEAR ;

expr: expr op=( '*' | '/' ) expr   # MulDiv
    | expr op=( '+' | '-' ) expr   # AddSub
    | INT                          # int
    | ID                           # id
    | '(' expr ')'                 # parens
    ;

MUL : '*' ;   // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
CLEAR : 'clear';


