#include <stdio.h>
#include <stdlib.h>
int* lpsArray(char* str,char* subst)
{
    int l=strlen(str);
    int k=strlen(subst);
    int *lps=(int*)malloc(k*sizeof(int)),i=0,j;
    lps[0]=0;
    for(j=1;j<k;)
    {
        if(subst[i]==subst[j])
        {
            lps[j]=i+1;
            i++;
            j++;
        }
        else
        {
            if(i==0)
            {
                lps[j]=0;
                j++;
            }
            else
            {
                i=lps[i-1];
            }
        }
    }
    for(i=0;i<k;i++)
    {
        printf("%d ",lps[i]);
    }
    return lps;
}
char* strstr(char* str,char* subst)
{
    int l=strlen(str);
    int k=strlen(subst);
// make lps table of subst
    int *lps=lpsArray(str,subst);
    int i,j=0;
//start comparing with str
    for(i=0;i<l;)
    {
        if(str[i]==subst[j])
        {
            i++;
            j++;
        }
        else if(j==0)
        {
            i++;
        }
        else
        {
            j=lps[j-1];
        }
        if(j==k)
            return &str[i-j];
    }
    return "-1";

}
int main()
{
//to know the position of subst in str if its present
    char str[50]="abcdabcefabcdabcd";
    char subst[11]="abcdabcd";
    char* occ=strstr(str,subst);
    printf("%s",occ);
    return 0;
}
