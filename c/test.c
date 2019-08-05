#include <stdio.h>
 
int main () {

  /* local variable declaration */
  int a, b;
  int c;
 
  /* actual initialization */
  a = 10;
  b = 20;
  c = a + b;
 
  // while (True) {
      // printf ("value of a = %d, b = %d and c = %d\n", a, b, c);
  // }
  while( a < 20 ) {
      printf("value of a: %d\n", a);
      a++;
   }
 
  return 0;
}