DATA   SEGMENT
A  DB 30H
B  DB 20H
C  DB 10H
D  DB 05H
Z  DB ?
DATA    ENDS
CODE    SEGMENT
         ASSUME  CS:CODE, DS:DATA
START:   MOV   AX,  DATA
         MOV   DS,  AX
         MOV   AL,  A
         ADD   AL,  B
         SUB   AL,  C
         ADD   AL,  D
         MOV    Z,  AL

         MOV   AX,  4CH
         INT   21H
 CODE   ENDS
         END  START
