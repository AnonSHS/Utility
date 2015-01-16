package encrypt;

import java.util.Scanner;
/*     */ 
class Encrypt{
     public static void main(String []args){
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("Type in the plain text to encrypt.\n");      
    	 System.out.println(Decipher(scanner.nextLine()));
     }
/*     */   public static String Decipher(String from_text)
/*     */   {
/*  19 */     char[] word = from_text.toCharArray();
/*  20 */     StringBuilder to_text = new StringBuilder();
/*  21 */     long key = NumericPassword("TblRefreshCurMonthServiceUse");
/*  22 */     int str_len = from_text.length() - 1;
/*  23 */     for (int i = 0; i < str_len; i++) {
/*  24 */       word[i] = from_text.charAt(i);
/*  25 */       int ch = word[i];
/*  26 */       if ((ch >= 32) && (ch <= 126)) {
/*  27 */         i++;
/*  28 */         ch -= 32;
/*  29 */         double offset = 96.0D * (
/*  30 */           key * i % 100537L / 100537.0D);
/*  31 */         ch = (ch - (int)offset) % 95;
/*  32 */         if (ch < 0)
/*  33 */           ch += 95;
/*  34 */         ch += 32;
/*  35 */         i--;
/*  36 */         to_text.append((char)ch);
/*     */       }
/*     */     }
/*  39 */     return to_text.toString();
/*     */   }
/*     */ 
/*     */   public static String Cipher(String from_text)
/*     */   {
/*  52 */     char[] word = from_text.toCharArray();
/*  53 */     StringBuilder to_text = new StringBuilder();
/*  54 */     long key = NumericPassword("TblRefreshCurMonthServiceUse");
/*  55 */     int str_len = from_text.length() - 1;
/*  56 */     for (int i = 0; i <= str_len; i++) {
/*  57 */       word[i] = from_text.charAt(i);
/*  58 */       int ch = word[i];
/*  59 */       if ((ch >= 32) && (ch <= 126)) {
/*  60 */         i++;
/*  61 */         ch -= 32;
/*  62 */         double offset = 96.0D * (
/*  63 */           key * i % 100537L / 100537.0D);
/*  64 */         ch = (ch + (int)offset) % 95;
/*  65 */         ch += 32;
/*  66 */         i--;
/*  67 */         to_text.append((char)ch);
/*     */       }
/*     */     }
/*  70 */     return to_text.toString() + "a";
/*     */   }
/*     */ 
/*     */   private static long NumericPassword(String password)
/*     */   {
/*  77 */     long shift1 = 0L;
/*  78 */     long shift2 = 0L;
/*  79 */     long value = 0L;
/*  80 */     int str_len = password.length();
/*  81 */     for (int i = 0; i < str_len; i++) {
/*  82 */       long ch = password.charAt(i);
/*  83 */       value ^= ch * MyIndex(shift1);
/*  84 */       value ^= ch * MyIndex(shift2);
/*  85 */       shift1 = (shift1 + 7L) % 19L;
/*  86 */       shift2 = (shift2 + 13L) % 23L;
/*     */     }
/*  88 */     value = (value ^ 0x18901) % 100537L;
/*  89 */     return value;
/*     */   }
/*     */ 
/*     */   private static long MyIndex(long shadow)
/*     */   {
/*  94 */     long j = 1L;
/*  95 */     for (long i = 1L; i <= shadow; i += 1L)
/*  96 */       j *= 2L;
/*  97 */     return j;
/*     */   }
/*     */ 
/*     */  
/*     */   
/*     */ }

/* Location:           /home/tony/Desktop/Self/WEB-INF/classes/
 * Qualified Name:     com.selfpackage.util.Encrypt
 * JD-Core Version:    0.6.2
 */