;已知X、Y、Z、MAX为16位的带符号数，求三个数中最大值，结果存入MAX单元。

DATA  SEGMENT
X     DB    0FH
Y     DB    30H
Z     DB    7FH
MAX   DB   ?
DATA ENDS

CODE  SEGMENT
   ASSUME   CS:CODE, DS:DATA
START:
   MOV   AX,   DATA
   MOV   DS,   AX

   MOV   AL,   X
   CMP   AL,   Y
   JNL   N1
   MOV   AL,   Y

N1:CMP   AL,   Z
   JNL   N2
   MOV  AL,   Z

N2:MOV   MAX,  AL

   MOV   AX,   4CH
   INT   21H
CODE  ENDS
   END   START
