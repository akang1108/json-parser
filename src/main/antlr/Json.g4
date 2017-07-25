grammar Json;

/*
    Parser Rules
    ------------
*/

root: node EOF ;
node: map | array ;
array: '[' nodeOrValue (',' nodeOrValue)* ']' ;
map: '{' keyValuePairs '}' ;

keyValuePairs: keyValuePair (',' keyValuePair)*;
keyValuePair: key ':' nodeOrValue ;

nodeOrValue: node | val ;
val: NUMBER | BOOLEAN | STRING;

key: STRING;

/*
    Lexer Rules
    -----------
*/

STRING: '"' ~["]+ '"' ;

NUMBER: [0-9]+ ;

BOOLEAN: 'true' |
         'false' ;

WS: [ \t\r\n]+ -> skip ;

