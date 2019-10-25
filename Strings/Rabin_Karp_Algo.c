#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include<string.h>

int searchPatt(char* str,char* patt,int p,long int m)
{
    int s_len=strlen(str);
    int p_len=strlen(patt);
    long int pow[s_len],h[s_len],h_p=0,sum=0;
    int i,j;
    pow[0]=1;

    for(i=1;i<s_len;i++)
    {
        pow[i]=(pow[i-1]*p)%m;
    }

    for(i=0;i<p_len;i++)
    {
        h_p=(h_p+(pow[i]*(patt[i]-'a'+1))%m)%m;
    }

    for(i=0;i<s_len;i++)
    {
        if(i==0)
        {
            h[i]=(0+(pow[i]*(str[i]-'a'+1))%m)%m;
        }
        else
        {
            h[i]=(h[i-1]+(pow[i]*(str[i]-'a'+1))%m)%m;
        }
    }
    sum=h[p_len-1];

    for(i=p_len;i<=s_len;i++)
    {
        if(sum==h_p)
        {
            for(j=0;j<p_len;j++)
            {
                if(patt[j]!=str[i-p_len+j])
                {
                    break;
                }
            }
            if(j==p_len)
            return (i-p_len);
        }
        sum=(h[i]+m-h[i-p_len])%m;
        h_p=(h_p*p)%m;
    }
    return -1;
}

int main()
{
    int n;
    printf("enter size of string1 : ");
    scanf("%d",&n);
    char* str=(char*)malloc(n*sizeof(char));
    printf("enter string : ");
    scanf("%s",str);
    int m;
    printf("enter size of pattern string which is to be found : ");
    scanf("%d",&m);
    char* patt=(char*)malloc(m*sizeof(char));
    printf("enter pattern string : ");
    scanf("%s",patt);
    int prime;
    scanf("%d",&prime);
    printf("enter a prime no. for the hash function : "); // to avoid collisions
    long int mac=1000000000+9; // not to exceed limit of integers
    int ans=searchPatt(str,patt,prime,mac);
    if(ans==-1)
        printf("Not found");
    else
        printf("string found at index %d ",ans);
    return 0;
}
