
export async function evaluate(arrFormula) {
    try{
      const arrPostfix = infix2Postfix(arrFormula);
      const result = await evaluatePostfix(arrPostfix);
      console.log(result,"evaluate func")
      return result
    }catch(e){
      console.log(e)
    }
}
  
  export function isNotNumber(input) {
    return input === '(' || input === ')' || input === '+' || input === '-' || input === '*' || input === '/' || input === '%';
  }
  
  export function isNumber(input) {
    return !isNotNumber(input);
  }
  
  export function isOperator(input) {
    return input === '+' || input === '-' || input === '*' || input === '/' || input === '%';
  }
  
  export function getPriority(input) {
    if (input === '+' || input === '-') return 1;
    else if (input === '*' || input === '/' || input === '%') return 2;
    return 0;
  }
  
  export function infix2Postfix(arrFormula) {
    let result = [], stack = [];
  
    arrFormula.forEach(item => {
      if (isNumber(item)) {
        result.push(item);
      } else if (item === '(') {
        stack.push(item);
      } else if (item === ')') {
        while (stack.length > 0) {
          const pulledItem = stack.pop();
  
          if (pulledItem === '(') break;
          else result.push(pulledItem);
        }
      } else if (isOperator(item)) {
        while (stack.length > 0) {
          const peekedItem = stack[stack.length - 1];
  
          if (isOperator(peekedItem) && getPriority(peekedItem) >= getPriority(item)) {
            result.push(peekedItem);
            stack.pop();
          } else break;
        }
  
        stack.push(item);
      } else {
        console.log("Something else!!!");
      }
    });
  
    while (stack.length > 0) {
      result.push(stack.pop());
    }
  
    return result;
  }

  async function getTotal(formula,num1,num2){
    let addData = await fetch(`/${formula}?firstNum=${num2}&secondNum=${num1}`,{method:'POST',headers:{'Content-Type': 'application/json'},mode:'cors'});
    let addjson = await addData.json();
    console.log(addjson.total)
    return addjson.total
  }

  async function calc(item,num1,num2,result){
      console.log('in calc func')
      let effOff = result;
      try{
        switch(item){
          
          case '+':
            effOff = await getTotal("add",num2,num1);
          break
          case '-':
            effOff = await getTotal("substract",num2,num1);
          break
          case '*':
            effOff = await getTotal("multiply",num2,num1);
          break
          case '/':
            if(num1 === 0 || num2 === 0) {
              alert('cant divide by zero')
            }
            effOff = await getTotal("divide",num2,num1);
          break
          case '%':
            effOff = await getTotal("percentage",num1,num2);
          break
          default:
            console.log('Something else!!!');
        }
        console.log(effOff)
        return effOff

      }catch(e){}
  }

  async function createStack(arrPostfix,stack){
    try{
      for (let index = 0; index < arrPostfix.length;index++){
        if(isNumber(arrPostfix[index])){
          stack.push(arrPostfix[index]);
        }else if (isOperator(arrPostfix[index])){
          const num1 = Number.parseFloat(stack.pop()), num2 = Number.parseFloat(stack.pop());
          let result = '';
          result = await calc(arrPostfix[index],num1,num2,result);
          stack.push(result + '');          
        }
      }
      return stack;
    }catch(e){}
  }


  export async function evaluatePostfix(arrPostfix){
      let stack = [];
      console.log('in main function')
      try{
        stack = await createStack(arrPostfix,stack);
        console.log(stack);
        return Number.parseFloat(stack[0])
      }catch(e){
        console.log(e)
      }
  }


 
  
 