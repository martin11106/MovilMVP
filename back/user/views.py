from django.shortcuts import get_object_or_404
from django.http import Http404

from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework import generics

from user.models import user

from user.serializer import userSerializers

class userList(APIView):
    # METODO GET PARA SOLICITAR INFO
    def get(self, request, format=None):
        queryset = user.objects.filter()
        serializer = userSerializers(queryset, many=True)
        return Response(serializer.data)

    def post(self, request, format=None):
        serializer = userSerializers(data = request.data)
        if serializer.is_valid():
            serializer.save()
            datas = serializer.data
            return Response(datas)
        return Response(serializer.errors, status = status.HTTP_400_BAD_REQUEST)
# Create your views here.
class  userDetail(APIView):
    
    def get_object(self, id):
        try:
            print(id)
            return user.objects.get(id=id)
        except user.DoesNotExist:
            return 404
    
    def get(self, request, id, format=None):
        user = self.get_object(id)
        if user != 404:
            #many = True No aplica si retorno un solo objeto
            serializer = userSerializers(user)
            return Response(serializer.data)
        else:
            return Response(user)
    
    def put(self, request, id, format=None):
        user = self.get_object(id)
        if user != 404:
            serializer = userSerializers(user, data=request.data)
            if serializer.is_valid():
                serializer.save()
                datas = serializer.data
                return Response(datas)
            else:
                return Response(serializer.errors, status = status.HTTP_400_BAD_REQUEST)
        else:
            return Response(status = status.HTTP_400_BAD_REQUEST)
    def delete(self, request, id, format=None):
        user = self.get_object(id)
        user.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)