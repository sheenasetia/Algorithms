#include <stdio.h>
#include <stdlib.h>
#include<string.h>
//Manacher's algo
int longest_Palendromic(char* s)
{
    int l=strlen(s);
    char str[2*l+2];
    int j=0;

//wrap the string with $'s to remove even odd confusion in strings
    for(int i=0;i<strlen(s);i++)
    {
        str[j++]='$';
        str[j++]=s[i];
    }
    
    str[j++]='$';
    str[j]='\0';
    int table[strlen(str)],i;
    table[0]=1;
    int left=0,right=0;
    
    for(i=1;i<strlen(str);i++)
    {
        if(right>=strlen(str))
            break;
        else if(i>right)
        {
            left=i-1;
            right=i+1;
            while(str[left]==str[right] && left>=0 && right<strlen(str))
            {
                left--;
                right++;
            }
            left++;
            right--;
            table[i]=right-left+1;
        }
        else if(i+(table[right-i])/2<right)
        {
            table[i]=table[right-i];
        }
        else if(i+(table[right-i])/2==right)
        {
            right++;
            left=(i-(right-i));
        while(str[left]==str[right] && left>=0 && right<strlen(str))
        {
            left--;
            right++;
        }
        left++;
        right--;
        table[i]=right-left+1;
        }
        else if(i+(table[right-i])/2>right)
        {
            table[i]=(right-i)*2+1;
        }
    }
   
    int max=table[0],pos=0;
    for(int i=1;i<strlen(str);i++)
    {
        if(table[i]>max)
        {
            printf("%d\n",max);
            max=table[i];
            pos=i;
        }
    }
    printf("pos %d",pos);
    
    for(int i=pos-(max/2-1);i<=pos+(max/2-1);i=i+2)
    {
        printf("%c",str[i]);
    }
    return max/2;
}
int main()
{
    int n;
    scanf("%d",&n);
    char* str=(char*)malloc(n*sizeof(char));
    scanf("%s",str);
    int len=longest_Palendromic(str);
    printf("Length of longest palendrome is : %d ",len);
    return 0;
}
