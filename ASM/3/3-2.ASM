DATA  SEGMENT
   BUFFER   DB    63, 73, 85, 76, 55, 97, 56, 95, 87, 79
   COUNT    EQU   $ - BUFFER
   MAX      DB    ?
DATA  ENDS

CODE  SEGMENT
   ASSUME   CS:CODE, DS:DATA
START:
   MOV   AX,   DATA
   MOV   DS,   AX

   MOV   SI,   OFFSET BUFFER
   MOV   CX,   COUNT
   MOV   AL,   [SI]
AGAIN:
   MOV   BL,   [SI + 1]
   CMP   AL,   BL
   JNL   NOTM
   MOV   AL,   BL
NOTM:
   INC   SI
   LOOP  AGAIN
   MOV   MAX,  AL
   MOV   AH,   4CH
   INT   21H
CODE  ENDS
   END   START
