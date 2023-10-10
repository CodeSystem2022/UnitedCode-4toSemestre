import jwl from "jsonwebtoken"

export const createAccesToken = (paylod) => {
    return new Promise((resolve,reject) => {
        jwl.sign(paylod, "xyz123", {expiresIn: "1d"},
    (err,token) => {
        if (err) reject(err);
        resolve(token);
    
    });
    });
};