#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char* strstr1(char* str,char* subst)
{
    int k=strlen(subst);
//concatenate subst, $ and str
    strcat(subst,"$");
    strcat(subst,str);
    int right=0,left=0,i;
    int z[strlen(subst)]; //zee value table
    z[0]=0;
    //printf("%s",subst);
    for(i=1;i<strlen(subst);i++)
    {
        if(i>=right)
        {
            left=right=i;
            while(subst[right]==subst[right-left])
            {
                right++;
            }
            z[i]=right-left;
            //printf("%d",z[i]);
        }
        else
        {
            if((z[i-left]+i)<right)
            {
                z[i]=z[i-left];
            }
            else
            {
                left=i;
                while(subst[right]==subst[right-left] && subst[right]!='\0')
                    right++;
                z[i]=right-left;
            }
        }

    }
    for(i=0;i<strlen(subst);i++)
    {
            if(z[i]==k)
            return &subst[i];
    }
    return "-1";
}
int main()
{
    char str[50]="aabcaabxaaaz";
    char subst[50]="acb";
    char* occ=strstr1(str,subst);
    if(!(occ=="-1"))
        printf("Found! Reference starts : %s\n",occ);
    else
        printf("No match!\n");
    return 0;
}
